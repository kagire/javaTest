$(document).ready(function() {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/employees",
        data: {format: 'json'},
        success: function(data){
        console.log(typeof(data));
        },
        error: function(){
        alert("Error");
        }
    });
});