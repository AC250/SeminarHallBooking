# SeminarHallBooking

Endpoints: 
<ol>
  <li><h3>GET</h3>
  <ul>
  <li><b>localhost:8080/booking/getBetweenDates</b><br>
    <p>Body: <br>{<br>"startDate" : "yyyy-MM-dd",<br>"endDate" : "yyyy-MM-dd"<br>}
    </p>
    </li>
  </ul>
    </li>
    <li><h3>POST</h3>
    <ul>
    <li><b>localhost:8080/booking/requestHall</b><br>
    <p>Body: <br>{<br>"capacity": "int",<br>"startDateAndTime" : "yyyy-MM-dd, HH:mm",<br>"endDateAndTime" : "yyyy-MM-dd, HH:mm"<br>}
    </p>
      </li>
    <li><b>localhost:8080/booking/bookHall</b><br>
    <p>Body: <br>{<br>"hallName": "hallName,<br>"date" : "yyyy-MM-dd",<br>"startTime" : "HH:mm",<br>"endTime" : "HH:mm"<br>}
    </p>
    </li>
    </ul>
      </li>
</ol>
