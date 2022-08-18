import axios from 'axios';
import React, { MouseEventHandler, useState } from 'react';
import '../App.css'
export default function (props: { toggle: MouseEventHandler<HTMLDivElement> }): React.ReactElement {
    const { toggle } = props;
    const [boisson,setBoisson]=useState<string>("");
    const [prix,setPrix]=useState<string>("");
    const [categorie,setCategorie]=useState<string>("")
    function update(){
        axios.patch("")
    }
    return (<>
        <div className='hide' onClick={toggle}></div>
        <div className='modale'>
            <div className='modale-head'>update</div>
            <p>boisson</p>
            <input type={"text"} value={boisson} onChange={(e:any)=>{setBoisson(e.target.value)}}/>
            <p>prix</p>
            <input type={"number"} value={prix} onChange={(e:any)=>{setPrix(e.target.value)}}/>
            <Categories onchange={setCategorie} value={categorie}/>
            <button onClick={update} className="btn-cocktail btn-custom">send</button>
        </div>
    </>
    )
}
export function Modale_new_drinks (props: { toggle: MouseEventHandler<HTMLDivElement> }): React.ReactElement {
    const { toggle } = props;
    const [boisson,setBoisson]=useState<string>("");
    const [prix,setPrix]=useState<string>("");
    const [categorie,setCategorie]=useState<string>("")
    function update(){
        axios.patch("")
    }
    return (<>
        <div className='hide' onClick={toggle}></div>
        <div className='modale'>
            <div className='modale-head'>new drinks</div>
            <p>boisson</p>
            <input type={"text"} value={boisson} onChange={(e:any)=>{setBoisson(e.target.value)}}/>
            <p>prix</p>
            <input type={"number"} value={prix} onChange={(e:any)=>{setPrix(e.target.value)}}/>
            <Categories onchange={setCategorie} value={categorie}/>
            <button onClick={update} className="btn-cocktail btn-custom">send</button>
        </div>
    </>
    )
}
function Categories(props:{onchange:any,value:any}): React.ReactElement {
    const{onchange,value}=props
    return (<>
        <p>categories</p>
        <input type={"text"} list="categories" value={value} onChange={(e:any)=>{onchange(e.target.value)}}/>
        <datalist id="categories">
            <option value="non-alcoliser" />
            <option value="alcoliser" />
        </datalist>
    </>
    )
}
export function Modale_newCocktail(props: { toggle: MouseEventHandler<HTMLDivElement> , boissons:any}): React.ReactElement {
    const { toggle , boissons} = props;
    return (<>
        <div className='hide' onClick={toggle}></div>
        <div className='modale modale-cocktail'>
        <div className='modale-head'>new coktail</div>
            {boissons.map((i:any)=>(<div className='row-input'>
                <input type="checkbox" name="" id="" /><p>{i.Name}</p>
                </div>
            ))}
            <button className="btn-cocktail btn-custom">send</button>
        </div>
    </>
    )
}