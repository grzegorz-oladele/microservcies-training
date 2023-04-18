# Kubernetes training project 

Kubernetes training project using microservices to include:
1. **Kanye** - service that displays Kanye'1 quotes from external API\
2. **Rick-and-Morty** - service that displays list of characters and list of locations from the popular cartoon Rick and Morty form external API
3. **Report** - service aggregating all requests sent to Kanye service and Rick-and-Morty service
4. **Proxy** - service that distributes requests to specific microservices

## REQUIREMENTS
1. RUN DOCKER

### HOW TO RUN APPLICATION
1. If you want to use docker -> command: `docker-compose up` if you are in _external-api_ directory
2. **!!PREFERRED!!** Use your local kubernetes cluster! To do this, go to the project 
https://github.com/grzegorz-oladele/microservices-deployment and run it as describe in the README

### ENDPOINTS
1. Get random Kanye's quote -> url [GET] http://localhost:8100/api/kanye/random-quote
2. Get list of characters from Rick and Morty cartoon -> url [GET] http://localhost:8100/api/rick-and-morty/charatcers?pageNumber=1
3. Get list of locations from Rick and Morty cartoon -> url [GET] http://localhost:8100/api/rick-and-morty/locations?pageNumber=2
4. Get list of requests sending to Kanye service or Rick-and-morty service -> url [GET] http://localhost:8100/api/reports?pageNumber=1