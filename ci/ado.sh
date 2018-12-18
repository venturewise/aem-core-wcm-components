#!/bin/bash
#
# Copyright 2018 Adobe Systems Incorporated
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

#######################################
# Helper for starting, killing and viewing the logs of AEM docker instances
#######################################

docker_repo="docker-aem-sp.dr.corp.adobe.com/aem-qe"

#######################################
# Show usage information
# Globals:
#   None
# Arguments:
#   None
# Returns:
#   None
#######################################
function show_usage {
    echo "Usage: ./ado.sh command [instance [version]]"
    echo "Supported command: start, tail, kill, login, pull"
    echo "Supported instance: author, publish"
    echo "Supported versions: 6330, 6420"
}

#######################################
# Print the current execution stage
# Globals:
#   None
# Arguments:
#   Execution stage name
# Returns:
#   None
#######################################
function stage {
    echo "----------------------------------------------"
	echo "- ${1} -"
	echo "----------------------------------------------"
}

#######################################
# Pull AEM image from docker repo
# Globals:
#   docker_repo
# Arguments:
#   None
# Returns:
#   None
#######################################
function docker_login {
    stage "Logging in to ${docker_repo}"
    docker login ${docker_repo}
}

#######################################
# Pull AEM image from docker repo
# Globals:
#   docker_repo
# Arguments:
#   AEM instance type (author/publish)
#   AEM version (ex: 6330/6420)
# Returns:
#   None
#######################################
function pull_image {
    stage "Pulling latest $1 version $2"
	docker pull ${docker_repo}/$2/$1
}

#######################################
# Prepare and start AEM instance
# Globals:
#   docker_repo
# Arguments:
#   AEM instance type (author/publish)
#   AEM version (ex: 6330/6420)
#   HTTP port to bind to (ex: 4502/4503)
# Returns:
#   None
#######################################
function start_aem {
    stage "Preparing $1 version $2 on port $3"
	docker run -h aem-$1 -d --name aem-$1 -p $3:$3 ${docker_repo}/$2/$1 ./init.sh
	sleep 15

	stage "Starting $1 version $2 on port $3";
	docker exec aem-$1 qp start --config qp-config.yaml --qs-jar cq/cq-quickstart-${2:0:1}.${2:1:1}.0.jar
}

#######################################
# Connect to an AEM docker container and tail the error.log
# Globals:
#   None
# Arguments:
#   AEM instance type (author/publish)
# Returns:
#   None
#######################################
function tail_log {
    docker exec -it aem-$1 tail -f cq/crx-quickstart/logs/error.log
}

#######################################
# Kill and remove all docker containers
# Globals:
#   None
# Arguments:
#   None
# Returns:
#   None
#######################################
function kill_all {
    stage "Stopping all containers"
	docker ps -q | xargs docker kill

	stage "Removing all containers"
	docker ps -a -q | xargs docker rm
}

#######################################
# Check arguments and run commands
#######################################

command=$1
instance=$2
version=$3

if [[ -z ${command} ]] ; then
    show_usage
    exit
fi

case ${command} in
login)
    docker_login
    ;;
pull)
    if [[ -z ${version} ]] ; then
            show_usage
        else
            case $instance in
                author | publish)
                    pull_image $instance $version
                ;;
                *) show_usage
                ;;
            esac
    fi
    ;;
start)
    if [[ -z ${version} ]] ; then
            show_usage
        else
            case $instance in
                author)
                    start_aem $instance $version 4502
                ;;
                publish)
                    start_aem $instance $version 4503
                ;;
                *) show_usage
                ;;
            esac
    fi
    ;;
tail)
    case $instance in
        author | publish)
            tail_log $instance
        ;;
        *)
            show_usage
        ;;
    esac
    ;;
kill)
    kill_all
    ;;
*)
    show_usage
    ;;
esac
