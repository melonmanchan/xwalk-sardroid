document.addEventListener('DOMContentLoaded', function () {
    // Example of creating a Java to JS binding
       echo.echoAsync('Hello world').then(
         function (result) {
           console.log(result);
         }
       );
});