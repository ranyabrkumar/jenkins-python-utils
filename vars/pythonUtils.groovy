def call(Map config = [:]) {
    def setupPythonEnv = new lib.setupPythonEnv(this)
    def buildDockerImage = new lib.buildDockerImage(this)
    def runTest = new lib.runTests(this)
    
    def defaults = [
        pythonVersion: '3.9',
        venvName: 'venv',
        imageName: 'python',
        tag: 'latest',
        testPath: 'tests',
        coverageThreshold: 80,
    ]
    config = defaults + config
    def pythonVersion = config.pythonVersion ?: defaults.pythonVersion
    def venvName = config.venvName ?: defaults.venvName

    def imageName = config.imageName ?: defaults.imageName
    def tag = config.tag ?: defaults.tag

    def testPath = config.testPath ?: defaults.testPath
    def coverageThreshold = config.coverageThreshold ?: defaults.coverageThreshold

    // Setup Python environment
    setupPythonEnv.setupPythonEnv(pythonVersion: pythonVersion, venvName: venvName)
    // Build Docker image
    buildDockerImage.buildDockerImage(imageName: imageName, tag: tag)
    // Run tests
    runTest.runTest(testPath: testPath, coverageThreshold: coverageThreshold)
    // Clean up 

   
}   
