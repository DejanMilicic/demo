import * as React from "react";
import { Demo } from "../Demo";
import { ResultTable } from "../../demoDisplay/results/resultItems";

const resultsCreator = () => <ResultTable
    fields={[
        "id",
        "name",
        "phone"
    ]}
/>;

export const SpatialIndexDemo = () => <Demo
    resultsComponents={resultsCreator}
/>;
