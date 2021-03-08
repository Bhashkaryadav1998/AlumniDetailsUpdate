let detailsUpdate=document.getElementById("details");
window.onload=fetch_values;
detailsUpdate.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    console.log("Event occured");
    if (detailsUpdate.checkValidity() === true) {
        document.getElementById("submit-button").style.display = "none";
        document.getElementById("spinner-button").style.display = "block";
        let response = await fetch('api/alumni/update', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                id: sessionStorage.getItem('id'),
                email: document.getElementById('email').value,
                contact_number: document.getElementById('contact').value,
            })
        });
        let result = await response;
        console.log(response);
        if(result['status'] === 200){
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";
            document.getElementById("success-alert").style.display = "block";
        }else{
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";

            document.getElementById("error-alert").style.display = "block";
        }
    }
});
async function fetch_values() {
    document.getElementById("success-alert").style.display = "none";
    document.getElementById('error-alert').style.display="none";
    if (!sessionStorage.getItem('id')) {
        location.href = "index.html";
        return;
    }
    console.log(sessionStorage.getItem('id'));
    let response = await fetch("api/alumni/view",{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id: sessionStorage.getItem('id'),
        })
    });
    let result = await response;
    console.log(response);
    if(result['status'] === 200){
        let data =await response.json();
        document.getElementById("name").value=data['name'];
        document.getElementById("email").value=data['email'];
        document.getElementById("contact").value=data['contact_number'];
        document.getElementById("sid").value=data['student_id'];
    }else{
    document.getElementById("error-alert").style.display="block";
    }
}
function logout(){
    sessionStorage.removeItem('id');
    sessionStorage.removeItem('id_edu');
    sessionStorage.removeItem('id_org');
    location.href="index.html";
}