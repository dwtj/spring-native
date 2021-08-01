#!/usr/bin/env bash

if [[ `cat target/native/test-output.txt | grep "Hello, world!"` ]]; then
  exit 0
fi
exit 1
