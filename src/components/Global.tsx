import React, { useState } from "react";
import { signOut, onAuthStateChanged } from "firebase/auth";
import { useEffect } from "react";
import { Button , Pagination} from "@mui/material";
import { auth } from '../conf/firebase'
import { useNavigate } from "react-router-dom";
import Modale ,{Modale_newCocktail, Modale_new_drinks}from './Modale';
import List_boissons from "./list_boissons";
import List_cocktail from "./list_cocktail";
export default function (): React.ReactElement {
  const [updateModale,setUpdateModale]=useState<boolean>(false)
  const [newCocktail,setnewCocktail]=useState<boolean>(false)
  const [newDrinks,setNewDrinks]=useState<boolean>(false)
  const [toggleToOther,setToggleToOther]=useState<boolean>(false)
  const navigate = useNavigate()
  function displayUpdateModale(){
      setUpdateModale(!updateModale)
  }
  function newDrinks_ok(){
    setNewDrinks(!newDrinks)
  }
  function toogleToAnother(){
    setToggleToOther(!toggleToOther)
  }
  function displaynewCocktailMenu(){
    setnewCocktail(!newCocktail)
  }
  function logout() {
    signOut(auth).then(() => {
      navigate("/login")
    }).catch((error) => {
      // An error happened.
    });
  }
  useEffect(() => {
    const unsubscribe = onAuthStateChanged(auth, (currentUser) => {
        if (currentUser) {
           
        }
        else {
          navigate('/Login');
        }
    });

    return () => unsubscribe();
}, []);
  const test=[
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
  return (<>
    {updateModale && <Modale toggle={displayUpdateModale}/>}
    {newCocktail&& <Modale_newCocktail boissons={test} toggle={displaynewCocktailMenu}/>}
    {newDrinks&& <Modale_new_drinks toggle={newDrinks_ok}/>}

    <div className="bg-ok"></div>
    <div className="global" style={(()=>(updateModale?{filter:"blur(3px)"}:{}))()}>
      {toggleToOther?
       <List_cocktail toggle={displayUpdateModale} toogleToOther={toogleToAnother} newCocktail={displaynewCocktailMenu}/>:
       <List_boissons toogleNew={newDrinks_ok} toggle={displayUpdateModale} toogleToOther={toogleToAnother}/>
      }
    </div>
    </>
  )
}