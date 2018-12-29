document.getElementsByName('files[]').item(0).addEventListener('change', handleFileSelect, false);

const zoomin=2;


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

happytime=[];//n*n


function createTrend(lines){
    const Trend = {};
    Trend.max=0;
    Trend.min=Number.MAX_VALUE;
    for (let i in lines){
        Trend.max=Math.max(Trend.max,lines[i]['y']);
        Trend.max=Math.max(Trend.max,lines[i]['y']);
    }
    Trend.child=lines;
    Trend.color=[0,0,0];
    Trend.width=1;
    Trend.style=function(){
        return "stroke:rgb("+this.color[0]+""+this.color[1]+""+this.color[2]+";stroke-width:"+this.width;
    };

    return Trend;
}

function createline(data){
    var line={};
    line.point=[];
    for (var i in data){
        line.point[i]=data[i];
    }
}

function createpoint(x,y){
    var point ={};
    point.x=x;
    point.y=y;
    return point;
}

var line=[];
line[0]=createline([{"x":1,"y":2}]);
// var Trend=createTrend(line);

lastpoint=[];


function paint(json){
    for (var i in json){
        //console.log(json[i]);
        for (var j in json[i]){
            var main = document.getElementById("mainsvg");
            var line=document.createElementNS("http://www.w3.org/2000/svg","line");
            line.setAttribute("x1",zoomin*lastpoint[parseInt(i)]['x']);
            line.setAttribute("y1",lastpoint[parseInt(i)]['y']);
            line.setAttribute("x2",zoomin*json[i][j]['x']);
            line.setAttribute("y2",json[i][j]['y']);
            if (i<100)
            line.setAttribute("style", "stroke:rgb(0, 0, 0);stroke-width:1");
            else  line.setAttribute("style", "stroke:rgb(0, 255, 0);stroke-width:1");

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

const group = [];//text
var time = new Array();//time
var sumtime=0;
var textArr = new Array();//svg array

function createtextSVG(text, times, id) {
    var ans = {};
    ans.pos = spiral(random(times));
    ans.txt = text;
    ans.size = times;
    ans.id ="txt"+id;
    return ans;
}

function notin(j, xx1,xx2, yy1,yy2) {
    var temp = document.getElementById("txt" + j);
    var w = temp.getBBox().width/2;
    var h = temp.getBBox().height/2;
    var x1 = 400 + textArr[j].pos.x + w, x2 = 400 + textArr[j].pos.x - w;
    var y1 = 250 + textArr[j].pos.y + h, y2 = 250 + textArr[j].pos.y - h;
    //x1y1,x1y2,x2y2,x2y1
    /*var dx1 = x1 - x, dx2 = x2 - x, dy1 = y1 - y, dy2 = y2 - y;
    if (dx1 * dy2 - dx1 * dy1 > 0) return true;
    if (dx2 * dy2 - dx2 * dy1 > 0) return true;
    if (dx1 * dy2 - dx2 * dy1 > 0) return true;
    if (dx1 * dy2 - dx2 * dy1 > 0) return true;*/
    if (xx1 < x2 && xx2 < x2) return true;
    if (yy1 < y2 && yy2 < y2) return true;
    if (xx1 > x1 && xx2 > x1) return true;
    if (yy1 > y1 && yy2 > y1) return true;
    return false;
}

function check(i) {
    var overlap = false;
    for (var j = 0; j < i; j++) {
        var temp = document.getElementById("txt" + j);
        //  console.log("txt" + j, temp.getBBox().height, temp.getBBox().width);
        var w = document.getElementById("txt" + i).getBBox().width/2;
        var h = document.getElementById("txt" + i).getBBox().height/2;
        var x1 = 400 + textArr[i].pos.x + w, x2 = 400 + textArr[i].pos.x - w;
        var y1 = 250 + textArr[i].pos.y + h, y2 = 250 + textArr[i].pos.y - h;
        //if (notin(j, x1, y2) && notin(j, x1, y1) && notin(j, x2, y1) && notin(j, x2, y2)); 可以包起来，所以不对
        if (notin(j, x1, x2, y1, y2));
        else
            return false;   //overlap
    }
    return true;
}

function size(i) {

    return Math.max(10,100-i);


}
//400+textArr[i].pos.x+-w 250+textArr[i].pos.y+-h
function createSVG(i) {
    var main = document.getElementById("main");
    var txt = document.createElementNS("http://www.w3.org/2000/svg", "text");
    //text - anchor="middle" transform = "translate(500,72)rotate(0)skewX(0)scale(1,1)" style = "font-size: 100px;fill: rgb(57, 59, 121);"
    txt.setAttribute("text-anchor", "middle");
    txt.setAttribute("transform", "translate(" + (400 + textArr[i].pos.x) + "," + (250 + textArr[i].pos.y) + ")rotate(0)skewX(0)scale(1,1)");
    txt.setAttribute("style", "font-size: " + size(i) + "px;fill: rgb(" + ~~(Math.random() * 255) + ", " + ~~(Math.random() * 255) + ", " + ~~(Math.random() * 255) + ");");
    txt.setAttribute("id", textArr[i].id);
    txt.textContent = textArr[i].txt;
    main.appendChild(txt);
    txt = document.getElementById(textArr[i].id);
    if (!check(i)) {
        var x = textArr[i].pos.x/25;
        var y = textArr[i].pos.y / 40;
        var theta = Math.sqrt(x * x + y * y);

        for (var j = Math.random(); j < 720; j += Math.random())
        {
            textArr[i].pos = spiral(theta + j);
            txt.setAttribute("transform", "translate(" + (400 + textArr[i].pos.x) + "," + (250 + textArr[i].pos.y) + ")rotate(0)skewX(0)scale(1,1)");
            if (check(i)) break;
        }
        if (!check(i)) {
            txt.setAttribute("transform", "translate(" + (40000 + textArr[i].pos.x) + "," + (25000 + textArr[i].pos.y) + ")rotate(0)skewX(0)scale(1,1)");
            console.log("overlap");
        }
    };
}

function rad(x) {
    var ans = x / 180 * Math.PI;
    return ans;
}

function spiral(x) { //x is radian         800px*500px
    var ans = new Object;
    ans.x = 4 * x * Math.cos(x);
    ans.y = 2 * x * Math.sin(x);
    return ans;
}



function random(x) {//10 round
    if (sumtime>=100)
        return Math.random() * 4 * Math.PI * (1 - Math.sqrt(x / sumtime));
    else
        return Math.random() * 4 * Math.PI * (1 - x / sumtime);
}
{
    function quickSort(arr, left, right) {
        var len = arr.length,
            partitionIndex,
            left = typeof left != 'number' ? 0 : left,
            right = typeof right != 'number' ? len - 1 : right;

        if (left < right) {
            partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    function partition(arr, left, right) {     //分区操作
        var pivot = left,                      //设定基准值（pivot）
            index = pivot + 1;
        for (var i = index; i <= right; i++) {
            if (arr[i] > arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    function swap(arr, i, j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        var temp = group[i];
        group[i] = group[j];
        group[j] = temp;
    }
}
var punctuation = new Array(",", ".", "?", "!",")","(","\"","\n");

function begin() {
    var text = document.getElementById("onlyinput").value;
    //       console.log(text);
    var LowerTxt = text.toLowerCase();
    //        console.log(LowerTxt);
    var finalTxt = "";
    for (var i = 0; i < LowerTxt.length; i++) {
        if (punctuation.indexOf(LowerTxt[i]) == -1) {
            finalTxt += LowerTxt[i];
        }
    }
    //           console.log(finalTxt);
    var value = finalTxt.split(" ");


    for (var i = 0; i < value.length; i++) {
        if (group.indexOf(value[i]) != -1) {
            time[group.indexOf(value[i])] += 1;
            sumtime++;
        } else {
            group.push(value[i]);
            time[group.indexOf(value[i])] = 1;
            sumtime++;
        }
    }
    console.log(group,time);
    quickSort(time, 0, time.length);

    for (var i = 0; i < time.length; i++) {
        textArr[i] = createtextSVG(group[i], time[i], i);
    }
    console.log(textArr);
    for (var i = 0; i < time.length; i++) {
        createSVG(i);
    }
}

