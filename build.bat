@echo off
echo Building Bajaj Finserv Qualifier Application...

REM Create directories
if not exist "target" mkdir target
if not exist "target\classes" mkdir target\classes

echo Compiling Java classes...

REM Check if Java is available
java -version >nul 2>&1
if errorlevel 1 (
    echo Error: Java is not installed or not in PATH
    pause
    exit /b 1
)

echo Note: This build script requires Maven for proper dependency management.
echo For a complete build, please install Maven and run: mvn clean package
echo.
echo To run the application, you need to have all Spring Boot dependencies in classpath.
echo The recommended approach is to use Maven or an IDE with Maven support.

pause
