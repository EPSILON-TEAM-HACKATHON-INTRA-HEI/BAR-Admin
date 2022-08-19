import React, { MouseEvent, MouseEventHandler, useState , useEffect} from 'react';
import axios from 'axios';
import { Button, Pagination } from "@mui/material";
export default function (props:{toggle:MouseEventHandler<HTMLTableCellElement>,newCocktail:MouseEventHandler<HTMLButtonElement> ,toogleToOther:MouseEventHandler<HTMLButtonElement>}): React.ReactElement {
    const {toggle,newCocktail,toogleToOther}=props;
    const [data,setData]=useState<any>()
    const boissons=[
        {
          "id": 0,
          "name": "string",
          "composition": [
            
              {
                "id": 0,
                "Name": "string",
                "UnitPrice": 0,
                "Category": "string"
              }
            
          ]
        }
      ]
    useEffect(()=>{
        axios.get("https://bar-admin.herokuapp.com/drinks",{
        auth:{
            username:"test",
            password:"test"
        }
    }).then((data)=>{setData(data)}).catch((Err)=>{console.log(Err)})
    })
    return (
        <div className="card-body list-div col-11">
            <h1>Cocktail</h1>
            <div className="cocktailList">
                {data !== undefined &&  data.map((j:any)=>(
                    <Cocktail cocktail={j} update={toggle}/>
                ))}
            </div>
            <Pagination className='pagination' />
            <button onClick={newCocktail} className="btn-cocktail">new cocktail</button>
            <button onClick={toogleToOther} className="btn-cocktail to_drinks">{"<--to drinks"}</button>
        </div>
    )
}
interface RowPropsType{
    cocktail:any;
    update:MouseEventHandler<HTMLTableCellElement>;
}
function Cocktail(props:RowPropsType): React.ReactElement {
    const {cocktail,update}=props;
    return (
        <div className='listCocktail'>
            <div>{cocktail.name}</div>
            {
                cocktail.composition.map((i:any)=>(<>
                    <h5>{i.Name}</h5>
                    <p>Price : {i.UnitPrice} ar</p>
                    <p>Category : {i.Category}</p>
                    </>
                ))
            }
        </div>
    )
}