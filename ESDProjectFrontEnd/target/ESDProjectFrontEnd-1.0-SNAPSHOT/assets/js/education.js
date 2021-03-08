let Alldata;
let ind=0;
window.onload=first;
async function first(){
    await fetch_values();
    fill(ind);
    init();
}

async function del(){
    let response = await fetch('api/alumni_edu/del', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id: sessionStorage.getItem('id_edu')
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

    if(ind==Alldata.length-1) document.getElementById('previous').style.display="none";
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
    deg=document.getElementById("degree").value;
    py=document.getElementById("pyear").value;
    jy=document.getElementById("jyear").value;
    cname=document.getElementById("college").value;
    address=document.getElementById("address").value;
    if (!sessionStorage.getItem('id')) {
        location.href = "index.html";
        return;
    }
    let form_data = new FormData();
    form_data.append("deg",deg);
    form_data.append("py",py);
    form_data.append("jy",jy);
    form_data.append("cname",cname);
    form_data.append("addr",address);
    form_data.append("aid",sessionStorage.getItem('id'));
    let response = await fetch("api/alumni_edu/add",{
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
    document.getElementById("degree").value=Alldata[id]['degree'];
    document.getElementById("pyear").value=Alldata[id]['passing_year'];
    document.getElementById("jyear").value=Alldata[id]['joining_year'];
    document.getElementById("college").value=Alldata[id]['college_name'];
    document.getElementById("address").value=Alldata[id]['address'];
    sessionStorage.setItem('id_edu',Alldata[id]['id']);
}
async function fetch_values() {
    document.getElementById("success-alert").style.display = "none";
    document.getElementById('error-alert').style.display="none";
    if (!sessionStorage.getItem('id')) {
        location.href = "index.html";
        return;
    }
    let response = await fetch("api/alumni_edu/view",{
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
    let response = await fetch('api/alumni_edu/update', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id: sessionStorage.getItem('id_edu'),
            alumni_id: sessionStorage.getItem('id'),
            degree:document.getElementById("degree").value,
            passing_year: document.getElementById("pyear").value,
            joining_year: document.getElementById("jyear").value,
            college_name: document.getElementById("college").value,
            address: document.getElementById("address").value
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