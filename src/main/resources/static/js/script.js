
try{
    fetch('/em/api/user')
        .then(res => res.json())
        .then(res => {

        console.log("Djamil --------- Success")
            var userListNode = document.getElementById('user-list');
            userListNode.innerHTML = "";

            var table = document.createElement("table");
            table.setAttribute("border","1");
            userListNode.appendChild(table);

            res.forEach(user => {

                var tr = document.createElement("tr");
                table.appendChild(tr);

                var td = document.createElement("td");
                var text = document.createTextNode(`${user.firstname}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${user.lastname}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                var button = document.createElement("button");
                button.setAttribute("type","button");
                button.onclick = function() {
                    showDetail(`${user.id}`);
                };
                text = document.createTextNode("Details");
                button.appendChild(text);
                td.appendChild(button);
                tr.appendChild(td);


            });

        })
}catch (error) {
     // TypeError: Failed to fetch
     console.log('There was an error', error);
};

function showDetail(userId){

    fetch("../api/user/"+userId)
    .then(res => res.json())
    .then(res => {
        var userDetailNode = document.getElementById('user-detail');
        userDetailNode.innerHTML = "";

        var p = document.createElement("p");
        var text = document.createTextNode(`ID: ${res.id}`);
        p.appendChild(text);
        userDetailNode.appendChild(p);

        p = document.createElement("p");
        text = document.createTextNode(`Firstname: ${res.firstname}`);
        p.appendChild(text);
        userDetailNode.appendChild(p);

        p = document.createElement("p");
        text = document.createTextNode(`lastname: ${res.lastname}`);
        p.appendChild(text);
        userDetailNode.appendChild(p);

        p = document.createElement("p");
        text = document.createTextNode(`Email: ${res.email}`);
        p.appendChild(text);
        userDetailNode.appendChild(p);

    });
}
