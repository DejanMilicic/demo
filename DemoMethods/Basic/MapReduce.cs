﻿using DemoMethods.Entities;
using DemoMethods.Indexes;
using Raven.Client.Indexes;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace DemoMethods.Basic
{
    public partial class BasicController : ApiController
    {
        [HttpGet]
        public object MapReduce()
        {
            using (var session = Store.OpenSession())
            {
                IList<Product_Sales.Result> results = session
                    .Advanced
                    .DocumentQuery<Product_Sales.Result, Product_Sales>()
                    .ToList();

                return results;
            }
        }
    }
}