﻿using System.Linq;
using DemoMethods.Entities;
using Raven.Client.Indexes;

namespace DemoMethods.Advanced
{
    public class IndexManyProduct : AbstractIndexCreationTask<Product>
    {
        public IndexManyProduct()
        {
            Map = products => from product in products
                              select new
                              {
                                  product
                              };
        }
    }
}