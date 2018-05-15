#!/bin/bash
test $(curl $(docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' calculator):8765/sum?a=1\&b=2) -eq 3
