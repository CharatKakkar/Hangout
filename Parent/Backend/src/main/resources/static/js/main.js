
 $('#email').keyup(async function(e){
   let emailVal = document.getElementById('email').value;
    if(!validateEmailFormat(emailVal)){
    setEmailLabel("Email format is invalid!");
     changeElementColour('labelHere',"red");
     setElementStatus('register',true);

    } else{
    emailValidateService.emails(emailVal).then(res => res.json())
        .then(data => {
        setEmailLabel(data.message);
        changeElementColour('labelHere',"green");
        setElementStatus('register',false);
        });
    }
 });

const http = {
    fetch: async function(url, options = {}) {
        const response = await fetch(url, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            ...options,
        });
        return response;
    }
};

 const emailValidateService = {
  emails : async(id) => {
  return await http.fetch('/hangoutAdmin/api/checkemails/' + id);
  }
};


  function setEmailLabel(message){
  const label = document.getElementById('labelHere');
  label.innerHTML= message;
  return ;
  }

const validateEmailFormat = (email) => {
  return email.match(
    /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
  );
};

  const changeElementColour = (elementId,colour) =>{
   document.getElementById(elementId).style.color = colour;
   };

  const setElementStatus = (elementId, status) => {
    document.getElementById(elementId).disabled = status;
  };