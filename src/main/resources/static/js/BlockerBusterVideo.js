let requestURL = "http://192.168.1.104:8080/api/film/";
let request = new XMLHttpRequest();
let output = document.getElementById("output");



function searchFilms() {

    let searchString = document.getElementById("filmFilter").value;
    let minRuntime = document.getElementById("minRuntime").value;
    let maxRuntime = document.getElementById("maxRuntime").value;
    if (maxRuntime == 0) {
        maxRuntime = 1000;
    }
    let filmCategory = document.getElementById("filmCategory").value;

    output.innerHTML = "";

    request.open("GET", requestURL);
    request.responseType = "json";
    request.send();
    request.onload = function () {


        let requestData = request.response;

        for (let i = 0; i < requestData.length; i++) {

            let filmId = requestData[i].filmId;
            let title = requestData[i].title;
            let runtime = requestData[i].length;
            let category = requestData[i].category;
            let rating = requestData[i].rating;
            let description = requestData[i].description;
            let actors = titleCase(requestData[i].actors);

            if (title.includes(searchString.toUpperCase()) &&
                runtime >= minRuntime && runtime <= maxRuntime
                && (category.includes(filmCategory) || filmCategory == "")) {

                let row = output.insertRow();
                row.setAttribute("class", "clickable");
                row.setAttribute("data-toggle", "collapse");
                row.setAttribute("data-target", "#film" + filmId);

                let infoRow = output.insertRow();
                let infoCell = infoRow.insertCell();
                infoCell.setAttribute("colspan", 4);
                infoCell.setAttribute("id", "film" + filmId);
                infoCell.setAttribute("class", "table-light text-dark collapse");

                let infoContent = document.createTextNode(description);
                let actorContent = document.createTextNode("Starring: " + actors);

                let txt = document.createElement("p");
                txt.append(infoContent);
                infoCell.append(txt);

                txt = document.createElement("i");
                txt.append(actorContent);
                infoCell.append(txt);

                let titleCell = row.insertCell();
                let categoryCell = row.insertCell();
                let ratingCell = row.insertCell();
                let runtimeCell = row.insertCell();

                titleCell.innerHTML = titleCase(title);
                runtimeCell.innerHTML = runtime;
                categoryCell.innerHTML = category;
                ratingCell.innerHTML = rating;

            }
        }
    }
}


function titleCase(str) {
    var splitStr = str.toLowerCase().split(' ');
    for (var i = 0; i < splitStr.length; i++) {
        splitStr[i] = splitStr[i].charAt(0).toUpperCase() + splitStr[i].substring(1);
    }
    return splitStr.join(' ');
}



