## Setup
Before tests can be run, you will need to add the version of 'chromedriver' for your system depending on the version of chrome you have.

1. Go to https://chromedriver.chromium.org/downloads
2. Download the correct version of chromedriver.exe (depending on your browser) and extract it
3. Place it in ./src/main/resources/
4. Tests can now be run by using gradlew in the console.
   1. Example: `.\gradlew clean deployment` will run a test on whether the application is deployable