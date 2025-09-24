@echo off
setlocal enabledelayedexpansion
cd /d "%~dp0"
if not exist TodoCLI.class (
  echo Compiling TodoCLI.java ...
  javac TodoCLI.java
  if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b 1
  )
)
echo Running To-Do List...
java TodoCLI
