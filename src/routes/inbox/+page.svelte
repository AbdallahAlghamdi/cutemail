<section>
  <table>
    <thead>
      <tr>
        <th></th>
        <th>
          sender
          <img src="srtoasty/sender.png" alt="" />
        </th>
        <th class="subject">Subject</th>
        <th>
          <img src="piiixl/icons/calendar.png" alt="" />
        </th>
        <th>
          <img src="piiixl/icons/postcard.png" alt="" />
        </th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><input type="checkbox" /></td>
        <td class="sender">abcd1234fdd</td>
        <td>s</td>
        <td>test</td>
        <td>test</td>
      </tr>
      <tr>
        <td><input type="checkbox" /></td>
        <td>Marcus</td>
        <td>Is this app working?</td>
        <td>test</td>
        <td>test</td>
      </tr>
      <tr>
        <td><input type="checkbox" /></td>
        <td>Admin</td>
        <td>Your account has been created!</td>
        <td>test</td>
        <td>test</td>
      </tr>
    </tbody>
  </table>
</section>

<style>
  .sender {
    width: 10px;
    text-wrap: nowrap;
    overflow: hidden;
  }
  thead {
    background-color: #f0c541;
    border-bottom: 2px solid #30346d;
  }

  thead th:first-child {
    background-color: #e76a3a;
    border-right: 2px #30346d solid;
  }
  tbody td {
    padding: 10px 5px;
  }
  tbody td:first-child {
    padding-right: 5px;
    padding-left: 5px;
    text-align: center;
    border-right: 2px #30346d solid;
    /* border-bottom: 2px #30346d solid; */
    background-color: #e76a3a;
  }
  th {
    /* box-shadow: inset 0px -2px black; */
    font-weight: normal;
    /* border-right: 2px #30346d solid;
    background-color: #f0c541;
    border-bottom: 2px #30346d solid; */
  }

  tbody tr {
    border-bottom: 2px #30346d solid;
  }
  img {
    width: 32px;
  }
  .subject {
    text-align: center;
  }
  table {
    border-collapse: collapse;
    width: 100%;
    font-size: 16px;
    border: 2px solid #30346d;
    /* font-size: 16px; */
    /* background-color: #e0f8cf; */
  }
  section {
    height: 100%;
    overflow: scroll;
  }
</style>
