let Alldata;
let ind=0;
window.onload=first;
async function first(){
    await fetch_values();
    fill(ind);
    init();
}
function clear(){
    $('form').trigger("reset");
}
async function del(){
    let response = await fetch('api/alumni_org/del', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id: sessionStorage.getItem('id_org')
        })
    });
    let result = await response;
    if(result['status'] === 200){
        await fetch_values();
        init();

        alert("Data Deleted Successfully");
    }else{

        alert("Some error occured!!");
        document.getElementById("error-alert").style.display = "block";
    }
}
function init(){
    if(ind==0) document.getElementById('next').style.display="none";
    else document.getElementById('next').style.display="block";

    if(ind==Alldata.length-1 || Alldata.length==0) document.getElementById('previous').style.display="none";
    else document.getElementById('previous').style.display="block";
}
function next(){
    ind-=1;
    fill(ind);
    sessionStorage.setItem('id_edu',Alldata[ind]['id']);
    init();
}
function prev(){
    ind+=1;
    fill(ind);
    sessionStorage.setItem('id_edu',Alldata[ind]['id']);
    init();
}
async function add(){
    org=document.getElementById("org").value;
    pos=document.getElementById("pos").value;
    jd=document.getElementById("jdate").value;
    ld=document.getElementById("ldate").value;
    if (!sessionStorage.getItem('id')) {
        location.href = "index.html";
        return;
    }
    let form_data = new FormData();
    form_data.append("org",org);
    form_data.append("pos",pos);
    form_data.append("jd",jd);
    form_data.append("ld",ld);
    form_data.append("aid",sessionStorage.getItem('id'));
    let response = await fetch("api/alumni_org/add",{
        method: 'POST',
        body:form_data
    });
    let result = await response;
    console.log(response);
    if(result['status'] === 200){
        await fetch_values();
        fill(0);
        init();
        alert("Data Added Successfully");
    }else{
        alert("Data cannot be added");
    }
}
function fill(id){
    document.getElementById("org").value=Alldata[id]['organisation'];
    document.getElementById("pos").value=Alldata[id]['position'];
    document.getElementById("jdate").value=Alldata[id]['joining_date'];
    document.getElementById("ldate").value=Alldata[id]['leaving_date'];
    sessionStorage.setItem('id_org',Alldata[id]['id']);
}
async function fetch_values() {
    document.getElementById("success-alert").style.display = "none";
    document.getElementById('error-alert').style.display="none";
    if (!sessionStorage.getItem('id')) {
        location.href = "index.html";
        return;
    }
    let response = await fetch("api/alumni_org/view",{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            alumni_id: sessionStorage.getItem('id'),
        })
    });
    let result = await response;
    if(result['status'] === 200){
        Alldata =await response.json();
        console.log(Alldata);
        init();
    }else{
        document.getElementById("error-alert").style.display="block";
    }
}

async function update(){
    let response = await fetch('api/alumni_org/update', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id: sessionStorage.getItem('id_org'),
            organisation:document.getElementById("org").value,
            alumni_id: sessionStorage.getItem('id').value,
            position: document.getElementById("pos").value,
            joining_date: document.getElementById("jdate").value,
            leaving_date: document.getElementById("ldate").value,
        })
    });
    let result = await response;
    console.log(response);
    if(result['status'] === 200){
        await fetch_values();
        init();

        document.getElementById("success-alert").style.display = "block";
    }else{

        document.getElementById("error-alert").style.display = "block";
    }
}
function logout(){
    sessionStorage.removeItem('id');
    sessionStorage.removeItem('id_edu');
    sessionStorage.removeItem('id_org');
    location.href="index.html";
}