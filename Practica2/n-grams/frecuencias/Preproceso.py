#!/usr/bin/env python
# coding: utf-8

# In[1]:


import pandas as pd


# In[2]:


def preprocesar(nombre_archivo, nombre_generar):
        df = pd.read_csv(nombre_archivo, delimiter=" ", names=["n_gram", "prob"])
        
        total = df["prob"].sum()

        df["prob"] = df["prob"].apply(lambda x : x / total)
        
        df.to_csv(nombre_generar, sep=" ", index=False, header=False)


# In[ ]:


preprocesar("english_quadgrams.txt", "cuatrigramas.txt")


# In[ ]:


preprocesar("english_words.txt", "palabras.txt")

