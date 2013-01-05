@ECHO OFF

:: path settings
SET rootPath=%~dp0
SET xsdSource=..\xJdfLib\src\main\resources\org\cip4\lib\xjdf\xsd\JDF20.xsd
SET xsdTarget=src\main\resources\org\cip4\lib\xprinttalk\xsd\

cls
echo.
echo -------------------------------
echo   PrintTalk 2.0 Schema Update
echo -------------------------------
echo.
echo   Update XJDF Schema before?
echo   This assumes sources of both libraries (xJdfLib and
echo   xPrintTalkLib) are located in the same directory.
echo.
echo   SAMPLE:
echo       Location xJdfLib:        C:\MySources\CIP4\xJdfLib
echo       Location xPrintTalkLib:  C:\MySources\CIP4\xPrintTalkLib
echo.
echo      (both projects are located in directory "C:\MySources\CIP4\")
echo.
echo.

SET /p "doUpdate= --> Update XJDF XML Schema now (recommended)? [Y] : "

:: copy file
IF "%doUpdate%"==NUL copy %rootPath%%xsdSource% %rootPath%%xsdTarget% 
IF "%doUpdate%"=="" copy %rootPath%%xsdSource% %rootPath%%xsdTarget% 
IF "%doUpdate%"=="Y" copy %rootPath%%xsdSource% %rootPath%%xsdTarget%
IF "%doUpdate%"=="y" copy %rootPath%%xsdSource% %rootPath%%xsdTarget%

:: update schema
echo.
echo Update Schema...
echo.
chdir /D %rootPath%
mvn antrun:run