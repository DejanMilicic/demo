import * as React from "react";
import { Demo } from "../Demo";

export const Demo101 = () => <Demo
    title="Demo 101"
    description="This is the description of demo 101."
    parameters={[
        { type: "text", name: "FirstName", placeholder: "John" },
        { type: "text", name: "LastName", placeholder: "Doe" }
    ]}
/>;