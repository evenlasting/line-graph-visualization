document.getElementsByName('files[]').item(0).addEventListener('change', handleFileSelect, false);



function handleFileSelect(evt) {
    const file = evt.target.files[0];
    const reader = new FileReader();
    reader.onload = (function (theFile) {
        return function (e) {
            var json = JSON.parse(e.target.result);
            json.length=Object.keys(json).length;
            console.log(Object.keys(json).length);
            for (i in json){
                lastpoint[parseInt(i)]=json[i][0];
            }
            paint(json);
        }
    })(file);
    reader.readAsText(file);
}
//------------------------------------file------------------------------------------------------
//relation=[json.length];
//trend=[];
// for (var i=0;i<json.length;i++) {
//     relation[i]=[json.length];
// }

lastpoint=[];


function paint(json){
    for (var i in json){
        //console.log(json[i]);
        for (var j in json[i]){
            var main = document.getElementById("mainsvg");
            var line=document.createElementNS("http://www.w3.org/2000/svg","line");
            line.setAttribute("x1",lastpoint[parseInt(i)]['x']);
            line.setAttribute("y1",lastpoint[parseInt(i)]['y']);
            line.setAttribute("x2",json[i][j]['x']);
            line.setAttribute("y2",json[i][j]['y']);
            line.setAttribute("style", "stroke:rgb(0, 0, 0);stroke-width:1");
            lastpoint[parseInt(i)]=json[i][j];
            // var circle = document.createElementNS("http://www.w3.org/2000/svg", "circle");
            // console.log(json[i][j]);
            // circle.setAttribute("cx", json[i][j]['x']);
            // circle.setAttribute("cy", json[i][j]['y']);
            // circle.setAttribute("r", 1);
           // circle.setAttribute("fill", this.group);
          //  circle.setAttribute("id", this.id);
            main.appendChild(line);

        }
    }
}



