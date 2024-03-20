
try{
    fetch('/em/api/response')
        .then(res => res.json())
        .then(res => {
            userSection(res)
            interviewSection(res)
            questionSection(res)
            responseSection(res)
        })
}catch (error) {
     // TypeError: Failed to fetch
     console.log('There was an error', error);
};


function userSection(res){

            var userListNode = document.getElementById('user-section');
            userListNode.innerHTML = "";

            var table = document.createElement("table");
            table.setAttribute("border","1");
            userListNode.appendChild(table);

            var titles = ["Id","Firstname","Lastname","Genre","Country", "Phone Number",
            "Email","Birth Date"]

            var trtitle = document.createElement("tr");
            table.appendChild(trtitle);

            titles.forEach(title => {
                var td = document.createElement("td");
                var text = document.createTextNode(`${title}`);
                td.appendChild(text);
                trtitle.appendChild(td);
            })


            res.forEach(response => {

                var tr = document.createElement("tr");
                table.appendChild(tr);

                var td = document.createElement("td");
                var text = document.createTextNode(`${response.user.id}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.user.firstname}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.user.lastname}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.user.genre}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.user.country}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.user.phoneNumber}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.user.email}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.user.birthDate}`);
                td.appendChild(text);
                tr.appendChild(td);

            });
}

function interviewSection(res){

            var userListNode = document.getElementById('interview-section');
            userListNode.innerHTML = "";

            var table = document.createElement("table");
            table.setAttribute("border","1");
            userListNode.appendChild(table);

            var titles = ["Id", "Company", "Title", "Description", "Required Skills"]

            var trtitle = document.createElement("tr");
            table.appendChild(trtitle);

            titles.forEach(title => {
                var td = document.createElement("td");
                var text = document.createTextNode(`${title}`);
                td.appendChild(text);
                trtitle.appendChild(td);
            })


            res.forEach(response => {

                var tr = document.createElement("tr");
                table.appendChild(tr);

                var td = document.createElement("td");
                var text = document.createTextNode(`${response.interview.interviewID}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.interview.company}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.interview.title}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.interview.description}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.interview.requiredSkills}`);
                td.appendChild(text);
                tr.appendChild(td);

            });
}

function questionSection(res){

            var userListNode = document.getElementById('question-section');
            userListNode.innerHTML = "";

            var table = document.createElement("table");
            table.setAttribute("border","1");
            userListNode.appendChild(table);

            var titles = ["Id", "Question", "Question Type"]

            var trtitle = document.createElement("tr");
            table.appendChild(trtitle);

            titles.forEach(title => {
                var td = document.createElement("td");
                var text = document.createTextNode(`${title}`);
                td.appendChild(text);
                trtitle.appendChild(td);
            })


            res.forEach(response => {

                var tr = document.createElement("tr");
                table.appendChild(tr);

                var td = document.createElement("td");
                var text = document.createTextNode(`${response.question.questionID}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.question.questionText}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.question.questionType}`);
                td.appendChild(text);
                tr.appendChild(td);

            });
}

function responseSection(res){

            var userListNode = document.getElementById('response-section');
            userListNode.innerHTML = "";

            var table = document.createElement("table");
            table.setAttribute("border","1");
            userListNode.appendChild(table);

            var titles = ["Id", "Response Text", "Score", "User Id", "Interview Id", "Question Id"]

            var trtitle = document.createElement("tr");
            table.appendChild(trtitle);

            titles.forEach(title => {
                var td = document.createElement("td");
                var text = document.createTextNode(`${title}`);
                td.appendChild(text);
                trtitle.appendChild(td);
            })


            res.forEach(response => {

                var tr = document.createElement("tr");
                table.appendChild(tr);

                var td = document.createElement("td");
                var text = document.createTextNode(`${response.responseID}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.responseText}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.score}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.user.id}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.interview.interviewID}`);
                td.appendChild(text);
                tr.appendChild(td);

                td = document.createElement("td");
                text = document.createTextNode(`${response.question.questionID}`);
                td.appendChild(text);
                tr.appendChild(td);

            });
}