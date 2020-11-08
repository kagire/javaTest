$(document).ready(function() {
    $.ajax({
          type: "GET",
          url: "http://localhost:8080/employees"
    }).then(function(data) {
        var counter = 1;
        for (const value of Object.values(data)) {
            var counterString = counter.toString();

            var employeeIdString = '.employee-id-' + counterString;
            var nameString = '.first-name-' + counterString;
            var lastNameString = '.last-name-' + counterString;
            var departmentIdString = '.department-id-' + counterString;
            var jobTitleString = '.job-title-' + counterString;
            var genderString = '.gender-' + counterString;
            var dateString = '.date-' + counterString;

            $(employeeIdString).append(value.employeeId);
            $(nameString).append(value.firstName);
            $(lastNameString).append(value.lastName);
            $(departmentIdString).append(value.departmentId);
            $(jobTitleString).append(value.jobTitle);
            $(genderString).append(value.gender);
            $(dateString).append(value.dateOfBirth);

            console.log(value.employeeId);
            counter++;
        }
        $('.count').append(counter - 1);
    });
    $("button").click(function(){
        var sendInfo = {
            "employeeId": 4,
            "firstName": "New",
            "lastName": "New",
            "departmentId": 7,
            "jobTitle": "Senior",
            "gender": "FEMALE",
            "dateOfBirth": "2020-11-06",
            "genderString": "FEMALE"
        };
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/employees",
            dataType: "json",
            data: sendInfo
        }).then(function(data) {
          var counter = 1;
          for (const value of Object.values(data)) {
              var counterString = counter.toString();
  
              var employeeIdString = '.employee-id-' + counterString;
              var nameString = '.first-name-' + counterString;
              var lastNameString = '.last-name-' + counterString;
              var departmentIdString = '.department-id-' + counterString;
              var jobTitleString = '.job-title-' + counterString;
              var genderString = '.gender-' + counterString;
              var dateString = '.date-' + counterString;
  
              $(employeeIdString).append(value.employeeId);
              $(nameString).append(value.firstName);
              $(lastNameString).append(value.lastName);
              $(departmentIdString).append(value.departmentId);
              $(jobTitleString).append(value.jobTitle);
              $(genderString).append(value.gender);
              $(dateString).append(value.dateOfBirth);
  
              console.log(value.employeeId);
              counter++;
          }
          $('.count').append(counter - 1);
      });
        alert("Created");
      });
});