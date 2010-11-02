#!/bin/bash
cat readme_header.txt > ../README.html
markdown ../../README.mkdn >> ../README.html
cat readme_footer.txt >> ../README.html
