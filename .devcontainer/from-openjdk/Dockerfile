FROM openjdk:11-jdk-slim

RUN apt-get update && apt-get install -y maven curl apt-transport-https ca-certificates gnupg
RUN echo "deb [signed-by=/usr/share/keyrings/cloud.google.gpg] https://packages.cloud.google.com/apt cloud-sdk main" | tee -a /etc/apt/sources.list.d/google-cloud-sdk.list 
RUN curl https://packages.cloud.google.com/apt/doc/apt-key.gpg | gpg --dearmor -o /usr/share/keyrings/cloud.google.gpg 
RUN apt-get update -y && apt-get install google-cloud-cli -y
RUN echo 'Installing additional software...' && \
    apt-get update && \
    apt-get install --no-install-recommends -qy \
        rsync \
        xorg \
        git \
        xmlstarlet \
        psmisc \
        chromium \
        zip \
        unzip \
        libnss3 \
        libgtk2.0-0 \
        jq \
        wget \
        bzip2 \
        iputils-ping

RUN echo 'Installing cypress dependencies..' && \
    apt-get update && \
    apt-get install --no-install-recommends -qy \
        libgtk-3-0 \
        libgbm-dev \
        libnotify-dev \
        libgconf-2-4 \
        libxss1 \
        libasound2 \
        libxtst6 \
        xauth \
        xvfb

# Create a new user
RUN useradd -ms /bin/bash jenkins

# Set permissions for Java and Maven
RUN chown -R jenkins:jenkins /usr/share/maven /usr/lib/jvm

# Set the user
USER jenkins

# Set the working directory
WORKDIR /home/jenkins
