#!/bin/bash
test $(curl $(docker network inspect -f '{{range .IPAM.Config}}{{.Gateway}}{{end}}' bridge):8765/sum?a=1\&b=2) -eq 3
