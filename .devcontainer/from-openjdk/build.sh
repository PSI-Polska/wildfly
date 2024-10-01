gcloud auth configure-docker europe-west3-docker.pkg.dev

docker build -t europe-west3-docker.pkg.dev/pocagrochocinski/docker-repo/openjdk-user .

docker push europe-west3-docker.pkg.dev/pocagrochocinski/docker-repo/openjdk-user

