def call() {
    echo 'Deploying the application'

    sh 'docker compose up -d'
    sh 'docker start db_cont || true'
}
