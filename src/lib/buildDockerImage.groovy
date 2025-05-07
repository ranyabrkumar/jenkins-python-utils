package lib
/**
* Executes a closure with a timeout
* @param timeout Timeout in minutes
* @param closure The closure to execute
*/
def buildDockerImage(Map config) {
    def imageName = config.imageName ?: 'python'
    def tag = config.tag ?: 'latest'
    
    steps {
        bat """docker build . -t ${imageName}:${tag}"""
    }
}