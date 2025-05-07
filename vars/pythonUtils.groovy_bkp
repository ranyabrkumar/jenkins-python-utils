def setupPythonEnv(String envName = 'venv', String pythonVersion = '3.9') {
    /**
     * Creates and activates a Python virtual environment.
     */
    try {
        bat """
                python${pythonVersion} -m venv ${venvName}
                call ${venvName}\\Scripts\\activate
                pip install --upgrade pip
                pip install -r requirements.txt
            """
    } catch (Exception e) {
        error "Error setting up Python environment: ${e.message}"
    }
}

def runTests(String testPath = 'tests', int coverageThreshold = 80) {
    /**
     * Executes pytest with coverage reporting.
     */
    try {
       bat """
            call venv\\Scripts\\activate
            python -m pytest ${config.testPath} --junitxml=unit_test_results.xml --cov=${config.testPath} --cov-fail-under=${config.coverageThreshold}
        """
    } catch (Exception e) {
        error "Error running tests: ${e.message}"
    }
}

def buildDockerImage(String imageName = 'python:latest') {
    /**
     * Builds a Docker image for the application.
     */
    try {
        if (!fileExists('Dockerfile')) {
            error "Dockerfile not found in the current directory."
        }
        bat """docker build . -t ${imageName}:${tag}"""
        echo "Docker image '${imageName}' built successfully."
    } catch (Exception e) {
        error "Error building Docker image: ${e.message}"
    }
}