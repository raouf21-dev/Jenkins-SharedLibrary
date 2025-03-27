def CheckCommiter(){
    def committer = sh(script: "git log -1 --pretty=format:'%ae'", returnStdout: true).trim()
    def ignoredUsers = "jenkins@example.com"

    if (ignoredUsers.contains(committer)) {
        echo "Commit by ignored user: ${committer}. Skipping build."
        currentBuild.result = 'ABORTED'
        return
    }
}