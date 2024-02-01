const url = "https://api.covid19api.com/total/country/united-states";

callAPI(url, function(status, data) {
  let latestData = data.slice(-5);

  for (let i = 0; i < latestData.length; i++) {
    let country = latestData[i].Country;
    let cases = latestData[i].Confirmed;
    let deaths = latestData[i].Deaths;
    let recovered = latestData[i].Recovered;
    let date = new Date(latestData[i].Date).toLocaleDateString();

    let blockId = `cards_block${i+1}`;
    let block = document.getElementById(blockId);

    let html = `
      <div>
        <p>Cidade: ${country}</p>
        <p>Casos: ${cases}</p>
        <p>Mortes: ${deaths}</p>
        <p>Recuperados: ${recovered}</p>
        <p>Data: ${date}</p>
      </div>
    `;

    block.innerHTML = html;
  }
});

function callAPI(url, callback) {
  var xhr = new XMLHttpRequest();
  xhr.responseType = "json";
  xhr.open("GET", url, true);
  xhr.onload = function() {
    if (xhr.status === 200) {
      callback(xhr.status, xhr.response);
    } else {
      alert("Problemas ao conectar no servidor.");
    }
  };
  xhr.send();
}