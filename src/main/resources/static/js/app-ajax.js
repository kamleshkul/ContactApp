//$(document).ready(function() {
//        $('#userName').blur(function(event) {
//                var name = $('#userName').val();
//                $.get('GetUserServlet', {
//                        userName : name
//                }, function(responseText) {
//                        $('#ajaxGetUserServletResponse').text(responseText);
//                });
//        });
//});
//

$( window ).unload(function() {
  return "Closing the application";
});