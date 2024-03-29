# MATLAB Compiler Runtime (MCR) v9.8 (R2020a)
#
# This docker file will configure an environment into which the Matlab compiler
# runtime will be installed and in which stand-alone matlab routines (such as
# those created with MATLAB's deploytool) can be executed.

# MATLAB Runtime
# Run compiled MATLAB applications or components without installing MATLAB
# The MATLAB Runtime is a standalone set of shared libraries that enables the
# execution of compiled MATLAB applications or components. When used together,
# MATLAB, MATLAB Compiler, and the MATLAB Runtime enable you to create and distribute
# numerical applications or software components quickly and securely.
#
# See https://www.mathworks.com/products/compiler/matlab-runtime.html for more info.
#
# @author Riccardo De Martis
# @creation 2020-Mar-24
#

FROM openjdk:8-jre
MAINTAINER Riccardo De Martis <riccardo@demartis.it>
ENV DEBIAN_FRONTEND noninteractive

RUN apt-get -q update && \
    apt-get install -q -y --no-install-recommends \
      xorg \
      unzip \
      wget \
      curl && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Download the MCR from MathWorks site an install with -mode silent
RUN mkdir /mcr-install && \
    mkdir /opt/mcr && \
    cd /mcr-install && \
    wget --no-check-certificate -q https://ssd.mathworks.com/supportfiles/downloads/R2021b/Release/0/deployment_files/installer/complete/glnxa64/MATLAB_Runtime_R2021b_glnxa64.zip && \
    unzip -q MATLAB_Runtime_R2021b_glnxa64.zip && \
    rm -f MATLAB_Runtime_R2021b_glnxa64.zip && \
    ./install -destinationFolder /opt/mcr -agreeToLicense yes -mode silent && \
    cd / && \
    rm -rf mcr-install

# Configure environment variables for MCR
ENV LD_LIBRARY_PATH /opt/mcr/v911/runtime/glnxa64:/opt/mcr/v911/bin/glnxa64:/opt/mcr/v911/sys/os/glnxa64:/opt/mcr/v911/extern/bin/glnxa64

ENV XAPPLRESDIR /etc/X11/app-defaults