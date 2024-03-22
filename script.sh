#!/bin/bash
# Check if any process is listening on port 8989
PIDS=$(lsof -t -i:8989 -sTCP:LISTEN)
if [ -n "$PIDS" ]; then
    # Kill the processes listening on port 8989
    kill -9 $PIDS
else
    echo "No process found listening on port 8989"
fi