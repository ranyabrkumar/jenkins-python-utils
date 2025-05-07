package lib
/**
* Executes a closure with a timeout
* @param timeout Timeout in minutes
* @param closure The closure to execute
*/
def runTest(Map config) {
    steps {
        bat """
            call venv\\Scripts\\activate
            python -m pytest ${config.testPath} --junitxml=unit_test_results.xml --cov=${config.testPath} --cov-fail-under=${config.coverageThreshold}
        """
    }
}