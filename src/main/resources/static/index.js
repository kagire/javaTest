$(document).ready(function() {
    $.ajax({
          type: "GET",
          url: "http://localhost:8080/employees"
    }).then(function(data) {
        console.log(typeof(data));
    });
});