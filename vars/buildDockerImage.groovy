def call(String imageName) {
    echo 'This is building the code'

    sh 'whoami'
    sh 'docker --version'

    sh "docker build -t ${imageName}:latest ."
}
