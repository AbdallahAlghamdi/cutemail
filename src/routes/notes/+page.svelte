<script lang="ts">
  const testNotes = [
    {
      id: "111",
      title:
        "My University Curriculumn, and how to change it for ever fafa how ot for ever as always as forever as alway",
    },
    { id: "222", title: "Test" },
    { id: "333", title: "Test" },
    { id: "444", title: "Test" },
    { id: "111", title: "Test" },
    { id: "111", title: "Test" },
    { id: "111", title: "Test" },
    { id: "111", title: "Test" },
  ];
</script>

<h2>Write notes, dont worry they are secure!</h2>
<section>
  {#each testNotes as note}
    <a href={`notes/${note.id}`} class="banner">
      <span class="title">{note.title}</span>
      <div class="actions">
        <img src="/icons/piiixl/ui/settings.png" alt="settings" />
        <img src="/icons/piiixl/ui/trashcan-closed.png" alt="settings" />
      </div>
    </a>
  {/each}
</section>

<style>
  h2 {
    margin-top: 10px;
    text-align: center;
    font-size: 32px;
    font-weight: normal;
  }
  section {
    /* height: 100%; */
    overflow: scroll;
  }
  .title {
    cursor: pointer;
  }
  .actions {
    display: flex;
    gap: 5px;
  }
  a {
    cursor: pointer;
    text-decoration: none;
  }
</style>
