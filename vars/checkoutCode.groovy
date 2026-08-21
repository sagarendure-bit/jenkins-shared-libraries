def call(String repoUrl, String branch = 'main') {
    echo "Cloning code from ${repoUrl}"

    git(
        url: repoUrl,
        branch: branch
    )

    echo 'Code cloning success'
