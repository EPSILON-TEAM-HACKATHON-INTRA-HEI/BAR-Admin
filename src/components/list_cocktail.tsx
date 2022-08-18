import React, { MouseEvent, MouseEventHandler } from 'react';
import { Button, Pagination } from "@mui/material";export default function (props:{toggle:MouseEventHandler<HTMLTableCellElement>,newCocktail:MouseEventHandler<HTMLButtonElement> ,toogleToOther:MouseEventHandler<HTMLButtonElement>}): React.ReactElement {
    const {toggle,newCocktail,toogleToOther}=props;
    const boissons=[
        {
            "id": 0,
            "Name": "string",
            "UnitPrice": 0,
            "Category": "string"
          },
          {
            "id": 0,
            "Name": "string",
            "UnitPrice": 0,
            "Category": "string"
          }
    ]
    return (
        <div className="card-body list-div col-11">
            <h1>Cocktail</h1><button onClick={toogleToOther}>to drinks</button>
            <div className="cocktailList">
                <Cocktail boissons={boissons} update={toggle}/>
                <Cocktail boissons={boissons} update={toggle}/>
            </div>
            <Pagination className='pagination' />
            <button onClick={newCocktail} className="btn-cocktail">new cocktail</button>
        </div>
    )
}
interface RowPropsType{
    boissons:any;
    update:MouseEventHandler<HTMLTableCellElement>;
}
function Cocktail(props:RowPropsType): React.ReactElement {
    const {boissons,update}=props;
    return (
        <div className='listCocktail'>
            <div>{"nom du cocktail"}</div>
            {
                boissons.map((i:any)=>(<>
                    <h5>{i.Name}</h5>
                    <p>Price : {i.UnitPrice} ar</p>
                    <p>Category : {i.Category}</p>
                    </>
                ))
            }
        </div>
    )
}