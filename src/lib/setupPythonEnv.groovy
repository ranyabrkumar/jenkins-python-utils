package lib
/**
* Executes a closure with a timeout
* @param timeout Timeout in minutes
* @param closure The closure to execute
*/
def setupPythonEnv(Map config) {
        def pythonVersion = config.pythonVersion ?: '3.9'
        def venvName = config.venvName ?: 'venv'

        steps {
            bat """
                python${pythonVersion} -m venv ${venvName}
                call ${venvName}\\Scripts\\activate
                pip install --upgrade pip
                pip install -r requirements.txt
            """
        }
}