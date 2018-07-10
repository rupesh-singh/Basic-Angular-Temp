
console.log('app.js')
let alertBox = document.querySelector('.alert');
let showBtn = document.querySelector('.btn-primary');
let hideBtn = document.querySelector('.btn-danger');
let greet = document.querySelector('.btn-success');

showBtn.addEventListener('click', function (e) {
    alertBox.style.display = "";
});

hideBtn.addEventListener('click', function (e) {
    alertBox.style.display = 'none';
});
greet.addEventListener('click',(e)=>{
alertBox.innerText="Good Morning!!!!!!!!!";
})

//----------------------------------------------------------------------------

let start = document.getElementById('start');
let stop = document.getElementById('stop');
let pov = document.getElementById('pov');
stop.setAttribute('disabled', true);

start.addEventListener('click',
    function (e) {

        stop.removeAttribute('disabled');
        start.setAttribute('disabled', true);

        let idx = 0;
        let interval = setInterval(() => {
            idx++;
            pov.src = `./images/${idx}.jpg`;
            if (idx === 3)
                idx = 0;

        }, 100)

        stop.addEventListener('click', () => {
            start.removeAttribute('disabled');
stop.setAttribute('disabled', true);

            clearInterval(interval)
        });


    }
)
//------------------------------------------------------------------


let load = document.querySelector('.btn-dark');
let jumbo = document.querySelector('.jumbotron');


load.addEventListener('click',()=>{

    let apiUrl="https://jsonplaceholder.typicode.com/comments?_limit=3";
    let promise=fetch(apiUrl)
    promise.then((response)=>response.json())
    .then(todos=>{
        let jsonData=JSON.stringify(todos[0].name);
        jumbo.innerText= jsonData;
       })
})














