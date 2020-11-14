$(document).ready(function() {

    var b = document.createElement('button');
    b.innerHTML = "Add employee";

    $.ajax({
          type: "GET",
          url: "http://localhost:8080/employees"
    }).then(function(data) {
        var counter = 0;
        var body = document.getElementsByTagName('body')[0];
        var tbl = document.createElement('table');
        tbl.style.width = '100%';
        tbl.setAttribute('border', '1');
        var tbdy = document.createElement('tbody');
      for (const value of Object.values(data)) {
            counter++;
            var tr = document.createElement('tr');
            var td1 = document.createElement('td');
            td1.appendChild(document.createTextNode(value.employeeId));
            var td2 = document.createElement('td');
            td2.appendChild(document.createTextNode(value.firstName));
            var td3 = document.createElement('td');
            td3.appendChild(document.createTextNode(value.lastName));
            var td4 = document.createElement('td');
            td4.appendChild(document.createTextNode(value.departmentId));
            var td5 = document.createElement('td');
            td5.appendChild(document.createTextNode(value.jobTitle));
            var td6 = document.createElement('td');
            td6.appendChild(document.createTextNode(value.gender));
            var td7 = document.createElement('td');
            td7.appendChild(document.createTextNode(value.dateOfBirth));
            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);
            tr.appendChild(td5);
            tr.appendChild(td6);
            tr.appendChild(td7);
            tbdy.appendChild(tr);
      }
      var tr1 = document.createElement('tr');
      var th1 = document.createElement('th');
      th1.appendChild(document.createTextNode("Total: " + counter));
      tr1.appendChild(th1);
      tbdy.appendChild(tr1);
      
      tbl.appendChild(tbdy);
      body.appendChild(tbl);

    body.appendChild(b); 
    });
    b.onclick = function(){
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
            data: sendInfo,
            context: document.body
        }).then(function(data) {
            var counter = 0;
            var body = document.getElementsByTagName('body')[0];
            var tbl = document.createElement('table');
            tbl.style.width = '100%';
            tbl.setAttribute('border', '1');
            var tbdy = document.createElement('tbody');
          for (const value of Object.values(data)) {
                counter++;
                var tr = document.createElement('tr');
                var td1 = document.createElement('td');
                td1.appendChild(document.createTextNode(value.employeeId));
                var td2 = document.createElement('td');
                td2.appendChild(document.createTextNode(value.firstName));
                var td3 = document.createElement('td');
                td3.appendChild(document.createTextNode(value.lastName));
                var td4 = document.createElement('td');
                td4.appendChild(document.createTextNode(value.departmentId));
                var td5 = document.createElement('td');
                td5.appendChild(document.createTextNode(value.jobTitle));
                var td6 = document.createElement('td');
                td6.appendChild(document.createTextNode(value.gender));
                var td7 = document.createElement('td');
                td7.appendChild(document.createTextNode(value.dateOfBirth));
                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);
                tr.appendChild(td4);
                tr.appendChild(td5);
                tr.appendChild(td6);
                tr.appendChild(td7);
                tbdy.appendChild(tr);
          }
          var tr1 = document.createElement('tr');
          var th1 = document.createElement('th');
          th1.appendChild(document.createTextNode("Total: " + counter));
          tr1.appendChild(th1);
          tbdy.appendChild(tr1);
          
          tbl.appendChild(tbdy);
          body.appendChild(tbl);

      });
        alert("Created");
      };
});