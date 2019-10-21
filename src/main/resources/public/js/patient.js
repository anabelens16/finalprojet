// configure AJAX dialog to be in JSON
var urlPatientRestApi = "api/patients"
$.ajaxSetup({
	contentType:"application/json; charset=utf-8"
})
	

// display data in the HTML
function displayOnePatientMore(patient){
	console.log("Display Patient:")
	console.log(patient)
	var patientHTML = 	$("<li></li>").text(
			patient['name'] + '(' 
			+  patient['firstname'] + ')'
			)
	$("#listePatient").append(patientHTML)
}

function displayPatients(Patients) {
	$("#listePatient").empty()
	$.each(Patients, function( i, patient) {
		displayOnePatientMore(patient)
	})
}

function getAndDisplayAllPatient() {
	// get data from the rest API
    $.getJSON(urlPatientRestApi)
    .fail(function(jqXHR, textStatus, errorThrown){
    	console.log("unable to access rest api ("
    			+urlPatientRestApi
    			+"):" +textStatus)
    })
    .done(displayPatients)
}

// send the data from the form to the Rest API
function postPatient(){		
	// retrieve data from form as a JSon
	var patient = {

			civility: $('#civility').val(),
			name:  $('#name').val(),
			firstname:  $('#firstname').val(),
			email:  $('#email').val(),
			phone:	$('#phone').val()
	}
	var patientJSON = JSON.stringify(patient)
	console.log("patient sent:")
	console.log(patient)
	console.log(patientJSON)
	// send the JSON data to rest api in POST
	$.post(urlPatientRestApi,patientJSON)
		.done(function(patientResponse) {
				console.log("patient added:")
				console.log(patientResponse)
				// refresh list patient
				displayOnePatientMore(patientResponse)
		})
		.fail(function(jqXHR, textStatus, errorThrown){
				console.log("Fail adding film:"+textStatus)
		})	
}

// After the page is loaded :
// display patient (GET)
// and attach event to submit form (prepare POST)
$(window).on('load',function(){
	getAndDisplayAllPatient()
//	getAndDisplayAllpatient()
	$("#formPatient").submit(function(event) {
		// prevent default submit mechanism
		event.preventDefault()
		postPatient()
	})
})