function getItems() {
    $.ajax({
        url: "http://localhost:8080/app/Registration",
        type: "GET",
        dataType: "json",
        success: function (data) {
            // console.log(data);
            _displayItems(data);

        },
        error: function (error) {
            console.log(`Error ${error}`);
        },
    });
}

function _displayItems(data) {
    const q1 = document.getElementById("column1");
    q1.innerHTML = "<h3>registrationsInOctober</h3><br>" +
        data.registrationsInOctober.map((event) => `<b>Event:</b> ${event.eventName}, <b>Count:</b> ${event.count}`).join("<br>");

    const q2 = document.getElementById("column2");
    q2.innerHTML = `<h3>OctoberRegistrations</h3><br>${data.octoberRegistrations.map(registration => `<b>Registration ID:</b> ${registration.registration_id}, <b>Event:</b> ${registration.event_name}, <b>Athlete:</b> ${registration.athlete_name}, <b>Registration Date:</b> ${registration.registration_date}`).join("<br>")}`;

    const q3 = document.getElementById("column3");
    q3.innerHTML = " <h3>PalindromeAthletes</h3><br>";
    q3.innerHTML = q3.innerHTML + Object.entries(data.palindromeAthletes).map(([key, value]) => `${key}: ${value}`).join("<br>");

    const q4 = document.getElementById("column4");
    q4.innerHTML = `<h3>FilteredRegistrations</h3><br>${data.filteredRegistrations.map(registration => `<b>Registration ID:</b> ${registration.registration_id}, <b>Event:</b> ${registration.event_name}, <b>Athlete:</b> ${registration.athlete_name}, <b>Registration Date:</b> ${registration.registration_date}`).join("<br>")}`;

    const q5 = document.getElementById("column5");
    q5.innerHTML = `<h3>SeptemberOctoberRegistrations</h3><br>${data.septemberOctoberRegistrations.map(registration => `<b>Registration ID:</b> ${registration.registration_id}, <b>Event:</b> ${registration.event_name}, <b>Athlete:</b> ${registration.athlete_name}, <b>Registration Date:</b> ${registration.registration_date}`).join("<br>")}`;

    const q6 = document.getElementById("column6");
    q6.innerHTML = `<h3>EventsOnSameDate</h3><br>${data.eventsOnSameDate.join(", ")}`;

    const tBody = document.getElementById("register");
    tBody.innerHTML = "";

    data.table1.forEach((item) => {

        let tr = tBody.insertRow();

        let td1 = tr.insertCell(0);
        let registration_id = document.createTextNode(item.registration_id);
        td1.appendChild(registration_id);

        let td2 = tr.insertCell(1);
        let event_name = document.createTextNode(item.event_name);
        td2.appendChild(event_name);

        let td3 = tr.insertCell(2);
        let athlete_name = document.createTextNode(item.athlete_name);
        td3.appendChild(athlete_name);

        let td4 = tr.insertCell(3);
        let registration_date = document.createTextNode(item.registration_date);
        td4.appendChild(registration_date);
    })
    register = data;
}

