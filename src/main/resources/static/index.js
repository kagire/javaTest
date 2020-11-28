import 'https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js';
import 'https://code.jquery.com/jquery-3.5.1.js';
import 'https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js';

var editor;

$(document).ready(function() {
  editor = new $.fn.dataTable.Editor( {
    "ajax": {
      "url": "http://localhost:8080/employees",
      "type": "GET"
    },
    "table": "#example",
    "fields": [ 
        {
            "label": "Id:",
            "name": "employee_id"
        }, {
            "label": "First name:",
            "name": "first_name"
        }, {
            "label": "Last name:",
            "name": "last_name"
        }, {
            "label": "Department id:",
            "name": "department_id"
        }, {
            "label": "Job title:",
            "name": "job_title"
        }, {
            "label": "Gender:",
            "name": "gender"
        }, {
            "label": "Birth date:",
            "name": "date_of_birth",
            "type": "datetime"
        }
    ]
} );

// New record
$('a.editor_create').on('click', function (e) {
  e.preventDefault();

  editor.create( {
      title: 'Create new record',
      buttons: 'Add'
  } );
} );

// Edit record
$('#example').on('click', 'a.editor_edit', function (e) {
  e.preventDefault();

  editor.edit( $(this).closest('tr'), {
      title: 'Edit record',
      buttons: 'Update'
  } );
} );

// Delete a record
$('#example').on('click', 'a.editor_remove', function (e) {
  e.preventDefault();

  editor.remove( $(this).closest('tr'), {
      title: 'Delete record',
      message: 'Are you sure you wish to remove this record?',
      buttons: 'Delete'
  } );
} );

$('#example').DataTable( {
  ajax: {
    "url": "http://localhost:8080/employees",
    "type": "GET"
  },
  columns: [
      { data: "employee_id" },
      { data: null, render: function ( data, type, row ) {
          // Combine the first and last names into a single table field
          return data.first_name+' '+data.last_name;
      } },
      { data: "department_id" },
      { data: "job_title" },
      { data: "gender" },
      { data: "date_of_birth" },
      {
          data: null, 
          className: "center",
          defaultContent: '<a href="" class="editor_edit">Edit</a> / <a href="" class="editor_remove">Delete</a>'
      }
  ]
} );
} );
